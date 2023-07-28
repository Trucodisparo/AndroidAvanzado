import com.keepcoding.androidsuperpoderes.data.dto.HeroDTO
import com.keepcoding.androidsuperpoderes.data.local.HeroLocal
import com.keepcoding.androidsuperpoderes.domain.model.HeroModel
import com.keepcoding.androidsuperpoderes.domain.model.LocationModel

fun HeroDTO.toHeroModel() = HeroModel(
    id = id ?: "",
    photoUrl = photo ?: "",
    name = name ?: "",
    favorite = favorite ?: false,
    description = description ?: ""
)

fun HeroDTO.toHeroLocal() = HeroLocal(
    id = id ?: "",
    name = name ?: "",
    photoUrl = photo ?: "",
    favorite = favorite ?: false,
    description = description ?: ""
)

fun HeroLocal.toHeroModel() = HeroModel(
    id = id,
    photoUrl = photoUrl,
    name = name,
    favorite = favorite,
    description = description,
)

fun HeroModel.toHeroLocal() = HeroLocal(
    id = id,
    photoUrl = photoUrl,
    name = name,
    favorite = favorite,
    description = description
)