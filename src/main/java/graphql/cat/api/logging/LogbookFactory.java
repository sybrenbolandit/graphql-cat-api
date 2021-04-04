package graphql.cat.api.logging;

import io.micronaut.context.annotation.Factory;
import org.zalando.logbook.Logbook;

import javax.inject.Singleton;

@Factory
public class LogbookFactory {
    @Singleton
    public Logbook logbook() {
        return Logbook.create();
    }
}
