# remove class files for recompilation
find . -name "*.class" -type f -delete

# check that class files are actually deleted (can be commented out)
ls -aR | grep class

# compile program
javac Main.java

# run program
java Main FileData/Notes3.zsong