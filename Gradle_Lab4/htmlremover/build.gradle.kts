plugins {
    id("java-library")
    id("application")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jsoup:jsoup:1.14.3")
}
application {
    mainClass = "Application"
}

tasks.named("run"){
    doFirst {
        println ("Uruchamiam aplikację z argumentami " + property("args"))
    }
}