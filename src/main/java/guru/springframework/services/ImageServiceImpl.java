package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.reactive.RecipeReactiveRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;


/**
 * Created by jt on 7/3/17.
 */
@Slf4j
@Service
public class ImageServiceImpl implements ImageService {


    private final RecipeReactiveRepository recipeReactiveRepository;

    public ImageServiceImpl(RecipeReactiveRepository recipeService) {

        this.recipeReactiveRepository = recipeService;
    }

    @Override
    public Mono<Void> saveImageFile(String recipeId, MultipartFile file) {

        Mono<Recipe> recipeMono = recipeReactiveRepository.findById(recipeId)
                .map(recipe -> {
                    Byte[] byteObjects = new Byte[0];
                        int i = 0;

                        while (i < byteObjects.length) {
                            byte b = byteObjects[i];
                            byteObjects[i++] = b;
                        }

                        recipe.setImage(byteObjects);
                        return recipe;
                });
        recipeReactiveRepository.save(recipeMono.block()).block();
        return Mono.empty();
    }
}
