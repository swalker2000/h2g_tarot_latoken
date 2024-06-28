package com.h2g.common.imagerepository

import dev.inmo.tgbotapi.requests.abstracts.InputFile
import java.io.File

object ImageRepository {

    enum class Format(val designation : String)
    {
        JPG("jpg"),
        JPEG("jpeg"),
        PNG("png")
    }

    fun get(directory : String, name: String): InputFile
    {
        fun getFileName(directory : String, name: String, format: Format) : String
        {
            return "images/$directory/${name}.${format.designation}"
        }

        val file : File? = Format.values().map{format ->
            File(getFileName(directory, name, format))}.firstOrNull() {file->
            file.exists()
        }
        if(file!=null)
            return InputFile(file)
        throw Exception("File ${file} not found!")
    }
}