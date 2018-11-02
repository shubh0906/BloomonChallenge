
#!/bin/sh

THE_CLASSPATH=
PROGRAM_NAME=src/bloomon.java
CLASS_NAME=bloomon


javac  $PROGRAM_NAME

if [ $? -eq 0 ]
then
  echo "compile worked!"
  cd src
  java  $CLASS_NAME
fi