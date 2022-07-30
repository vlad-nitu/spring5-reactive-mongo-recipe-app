package guru.springframework.repositories.reactive;

import guru.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CategoryReactiveRepositoryTest {

    @Autowired
    CategoryReactiveRepository categoryReactiveRepository;

    @Before
    public void setUp() throws Exception {
        categoryReactiveRepository.deleteAll().block();
    }

    @Test
    public void saveCategory() {
        Category category = new Category();
        category.setDescription("category");
        categoryReactiveRepository.save(category).block();
        assertEquals(categoryReactiveRepository.count().block(),Long.valueOf(1L));
    }

    @Test
    public void findByDescription() {
        Category category1 = new Category();
        category1.setDescription("category");
        Category category2 = new Category();
        category2.setDescription("something else");
        categoryReactiveRepository.save(category1).block();
        categoryReactiveRepository.save(category2).block();

        assertEquals(categoryReactiveRepository.findByDescription("category").block().getDescription(), "category");
    }
}