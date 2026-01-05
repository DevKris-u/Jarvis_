#!/usr/bin/env sh

DIR="$(cd "$(dirname "$0")" && pwd)"

CLASSPATH="$DIR/gradle/wrapper/gradle-wrapper-shared-8.2.jar"

exec java -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
