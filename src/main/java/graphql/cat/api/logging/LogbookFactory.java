package graphql.cat.api.logging;

import io.micronaut.context.annotation.Factory;
import org.zalando.logbook.Logbook;

import javax.inject.Singleton;

import static org.zalando.logbook.Conditions.exclude;
import static org.zalando.logbook.Conditions.requestTo;
import static org.zalando.logbook.HeaderFilters.authorization;

@Factory
public class LogbookFactory {
    @Singleton
    public Logbook logbook() {
        return Logbook.builder()
                .condition(exclude(requestTo("/health")))
                //.queryFilter(replaceQuery("password", "<secret>"))
                .headerFilter(authorization())
                //.sink(new DefaultSink(
                //        new SplunkHttpLogFormatter(),
                //        new DefaultHttpLogWriter()))
                .build();
    }
}
