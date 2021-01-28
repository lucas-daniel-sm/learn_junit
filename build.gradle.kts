plugins {
	java
    application
}

repositories { jcenter() }

fun junitDependecyBuilder(artifactId: String, version: String = "5.7.0"): String = "org.junit.jupiter:$artifactId:$version"

dependencies {
	testImplementation(junitDependecyBuilder("junit-jupiter-api"))
	testImplementation(junitDependecyBuilder("junit-jupiter-params"))
	
	testRuntimeOnly(junitDependecyBuilder("junit-jupiter-engine"))
}

application { mainClass.set("com.lucas.learn_junit.App") }

val test by tasks.getting(Test::class) { useJUnitPlatform() }
