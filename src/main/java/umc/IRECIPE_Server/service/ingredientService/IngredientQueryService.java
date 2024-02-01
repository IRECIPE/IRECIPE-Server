package umc.IRECIPE_Server.service.ingredientService;

import org.springframework.data.domain.Page;
import umc.IRECIPE_Server.common.enums.Type;
import umc.IRECIPE_Server.entity.Ingredient;


import java.util.Optional;

public interface IngredientQueryService {
    Ingredient findOne(Long ingredientId);

    void delete(Long ingredientId);

    Page<Ingredient> getIngredientList(Long memberId, Integer page);

    Page<Ingredient> getIngredientListByType(Long memberId, Type type, Integer page);

    Page<Ingredient> searchIngredientByName(Long memberId, String name, Integer page);
}
