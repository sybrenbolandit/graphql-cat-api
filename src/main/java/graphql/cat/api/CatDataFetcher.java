package graphql.cat.api;

import graphql.cat.api.domain.CatDTO;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import javax.inject.Singleton;

@Singleton
public class CatDataFetcher implements DataFetcher<CatDTO> {
    @Override
    public CatDTO get(DataFetchingEnvironment dataFetchingEnvironment) {
        System.out.println("".isEmpty());
        return new CatDTO("Fred", 4);
    }
}
