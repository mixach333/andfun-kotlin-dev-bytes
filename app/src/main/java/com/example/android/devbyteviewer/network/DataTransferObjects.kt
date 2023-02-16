/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.android.devbyteviewer.network

import com.example.android.devbyteviewer.database.DatabaseVideo
import com.example.android.devbyteviewer.domain.Video
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkVideoContainer(val videos: List<NetworkVideo>)

@JsonClass(generateAdapter = true)
data class NetworkVideo(
        val title: String,
        val description: String,
        val url: String,
        val updated: String,
        val thumbnail: String,
        val closedCaptions: String?)

fun NetworkVideoContainer.asDomainModel(): List<Video> {
    return videos.map {
        Video(
                title = it.title,
                description = it.description,
                url = it.url,
                updated = it.updated,
                thumbnail = it.thumbnail)
    }
}

fun NetworkVideoContainer.asDatabaseModel(): Array<DatabaseVideo> {
    return videos.map {
        DatabaseVideo(
                title = it.title,
                description = it.description,
                url = it.url,
                updated = it.updated,
                thumbnail = it.thumbnail)
    }.toTypedArray()
}
