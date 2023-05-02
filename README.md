[![](https://jitpack.io/v/hadibtf/PulsingCircle.svg)](https://jitpack.io/#hadibtf/PulsingCircle)
# Pulsing Circle Animation for Jetpack Compose

A cool animation you can use in your Compose app!

![demo.gif](https://github.com/hadibtf/PulsingCircle/blob/master/demo/demo-1.gif "Demo Gif")
![demo.gif](https://github.com/hadibtf/PulsingCircle/blob/master/demo/demo-1.jpg "Demo Picture")


## Installation

Add this repository to your Module settings.gradle

```bash
dependencyResolutionManagement {
    ...
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
And then add this dependency to your Project build.gradle

```bash
dependencies {
    implementation 'com.github.hadibtf:PulsingCircle:1.0.0'
}
```

## Usage

```kotlin
//kotlin
PulsingCircle()
```