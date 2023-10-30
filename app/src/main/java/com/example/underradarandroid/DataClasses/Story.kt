package com.example.underradarandroid.DataClasses

import java.io.Serializable

data class Story (
    val id: String = "",
    val title: String = "",
    val description: String = "",
    var headerImage: String? = null,
    val date : String = "",
    val state : String = "",
    val isPublished : Boolean = false,
    val isPendingReview : Boolean = true,
    val authorId: String = "",
//    var sections: [StorySection]? = nil,
//var tags: [StoryTag]? = nil,
): Serializable
