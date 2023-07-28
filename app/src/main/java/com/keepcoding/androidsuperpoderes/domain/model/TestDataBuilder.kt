package com.keepcoding.androidsuperpoderes.domain.model

class TestDataBuilder() {
    var id = ""
    var name = ""
    var photoUrl = ""
    var numElements: Int = 1
    var favorite = false
    var description = ""

    fun withName(name: String): TestDataBuilder{
        this.name =  name
        return  this
    }
    fun withPhotoUrl(photoUrl: String): TestDataBuilder{
        this.photoUrl =  photoUrl
        return  this
    }
    fun withNumElements(numElements: Int): TestDataBuilder{
        this.numElements =  numElements
        return  this
    }

    fun withFavorite(favorite: Boolean): TestDataBuilder{
        this.favorite =  favorite
        return  this
    }

    fun withDescription(description: String): TestDataBuilder{
        this.description =  description
        return  this
    }

    fun build():List<HeroModel>{
        val list = mutableListOf<HeroModel>()
        for(i in 0 .. numElements){
            list.add(HeroModel(id, name, photoUrl, favorite, description))
        }
        return list.toList()
    }

    fun buildSingle():HeroModel{
        return HeroModel(id, name, photoUrl, favorite, description)
    }

}