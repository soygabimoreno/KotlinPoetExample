package soy.gabimoreno.poetexample.javapoet

import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import javax.lang.model.element.Modifier

fun main() {
    val main = MethodSpec.methodBuilder("main")
        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
        .returns(Void.TYPE)
        .addParameter(Array<String>::class.java, "args")
        .addStatement("\$T.out.println(\$S)", System::class.java, "Hello, JavaPoet!")
        .build()

    val helloWorld = TypeSpec.classBuilder("HelloWorld")
        .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
        .addMethod(main)
        .build()

    val file = JavaFile.builder("soy.gabimoreno.poetexample", helloWorld).build()
    file.writeTo(System.out)
}
