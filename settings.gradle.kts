rootProject.name = "gradle buildSrc Versions issue"
include("wwsc")

// Not sure this is needed, but i'm having some issues with my  intellij and this fixed it
project(":wwsc").name = "wwsc"
