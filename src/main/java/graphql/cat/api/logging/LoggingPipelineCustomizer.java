package graphql.cat.api.logging;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.event.BeanCreatedEvent;
import io.micronaut.context.event.BeanCreatedEventListener;
import io.micronaut.http.netty.channel.ChannelPipelineCustomizer;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.netty.LogbookServerHandler;

import javax.inject.Singleton;

@Requires(beans = Logbook.class)
@Singleton
class LoggingPipelineCustomizer implements BeanCreatedEventListener<ChannelPipelineCustomizer> {

    private final Logbook logbook;

    public LoggingPipelineCustomizer(Logbook logbook) {
        this.logbook = logbook;
    }

    @Override
    public ChannelPipelineCustomizer onCreated(BeanCreatedEvent<ChannelPipelineCustomizer> event) {
        ChannelPipelineCustomizer customizer = event.getBean();
        customizer.doOnConnect(pipeline -> {
            pipeline.addAfter(
                    ChannelPipelineCustomizer.HANDLER_HTTP_SERVER_CODEC,
                    "logbook",
                    new LogbookServerHandler(logbook)
            );
            return pipeline;
        });

        return customizer;
    }
}
