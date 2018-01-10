/*
* Please solve the following puzzle which simulates generic directory structures.
* The solution should be directory agnostic.
* Be succinct yet readable. You should not exceed more than 200 lines.
* Consider adding comments and asserts to help the understanding.
* Code can be compiled with javac Directory.java
* Code should be executed as: java -ea Directory (-ea option it's to enabled the assert)
*/
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

/**
 * @author: Akhilesh Maloo
 * @date: 1/9/18.
 */
class Shell {

    /* {Assuming I need to create file structure}

    public class file {
        private String name;

        private file currDir;
        private file parentDir;

        public ArrayList<file> childFiles;
        public boolean isDir;

        file(String name, file currentDir, boolean dir) {

            this.name = name;
            this.currDir = currentDir;
            this.parentDir = currentDir.getParent();
            this.isDir = dir;

            if(dir) {
                childFiles = new ArrayList<file>();
            }

        }

        public file getParent() {
            return this.parentDir;
        }

        public void rename(String newName) {
            this.name = newName;
        }

    }

    private file root;

    Shell() {
        this.root = new file("/",null,true);
    }

    */


    // pointer to current address : initialized at root {to satisfy first assert}
    private File currentPtr;

    Shell() {
        currentPtr = new File("/");
    }

    /**
     * Change directory
     *
     * @param path
     * @return
     * @throws IOException
     */
    Shell cd(final String path) throws IOException {
        if (path.charAt(0) == '/') {
            currentPtr = new File(path);
        } else {
            try {
                File target = new File(currentPtr.getCanonicalPath() + "/" + path);

                //check if new target file exist
                if (target.isFile() || target.isDirectory())
                    // change to target directory
                    currentPtr = target;
                else
                    System.out.println("No such file or directory exist.");

            } catch (IOException e) {
                System.out.println("Invalid path");
                e.printStackTrace();
            }
        }
        return this;
    }

    /**
     * Create a new file
     *
     * @param path
     * @throws IOException
     */
    void touch(final String path) throws IOException {
        if (new File(this.currentPtr.getCanonicalPath() + "/" + path).createNewFile())
            System.out.println("New file created: " + path);
        else
            System.out.println("Invalid path or file already exists");
    }

    /**
     * deletion of files
     *
     * @param path
     * @throws IOException
     */
    void del(final String path) throws IOException {
        File fileToDel = new File(this.currentPtr.getCanonicalPath() + "/" + path);
        if (fileToDel.exists()) {
            fileToDel.delete();
            System.out.println("File deleted" + path);
        }
    }

    /**
     * Make directory function
     *
     * @param path
     * @throws IOException
     */
    void mkdirs(final String path) throws IOException {

        // supports nesting folder creation by mkdir(s)
        if (new File(this.currentPtr.getCanonicalPath() + "/" + path).mkdirs())
            System.out.println("Directory created: " + path);
        else
            System.out.println("Invalid path or Folder exists");

    }

    /**
     * Delete folder while deleting all the files inside it.
     *
     * @param path
     * @throws IOException
     */
    void rmdir(final String path) throws IOException {

        File folderToDel = new File(this.currentPtr.getCanonicalPath() + "/" + path);

        if (folderToDel.exists()) {
            for (String s : folderToDel.list()) {
                del(path + "/" + s);
            }
            folderToDel.delete();
        } else {
            System.out.println("Folder does not exist");
        }
    }

    public String path() throws IOException {
        return this.currentPtr.getCanonicalPath();
    }
}

public class Directory {
    public static void main(String[] args) throws IOException {
        final Shell shell = new Shell();

        System.out.println(shell.path().equals("/"));
        //assert shell.path().equals("/");


        shell.cd("/");
        System.out.println(shell.path().equals("/"));
        //assert shell.path().equals("/");

        shell.cd("usr/..");
        System.out.println(shell.path().equals("/"));
//        assert shell.path().equals("/");

        shell.cd("usr").cd("local");
        shell.cd("../local").cd("./");
        System.out.println(shell.path().equals("/usr/local"));
        // assert shell.path().equals("/usr/local");

        shell.cd("..");
        System.out.println(shell.path().equals("/usr"));
//        assert shell.path().equals("/usr");


//        shell.cd("//lib///");
//        System.out.println(shell.path().equals("/lib"));
////        assert shell.path().equals("/lib");



        //create a folder & check
        shell.mkdirs("../Users/akhi/tempDir");
        shell.cd("../Users/akhi/tempDir");
        //assert shell.path().equals("/tempDir");
        System.out.println(shell.path().equals("/Users/akhi/tempDir"));

        //create a file & check
        shell.touch("tempFile.txt");
        shell.cd("tempFile.txt");
        //assert shell.path().equals("/Users/tempDir/tempFile.txt");
        System.out.println(shell.path().equals("/Users/akhi/tempDir/tempFile.txt"));

        //create a file 2 & check
        shell.cd("/Users/akhi/tempDir");
        shell.touch("tempFile2.txt");
        shell.cd("tempFile2.txt");
        //assert shell.path().equals("/Users/tempDir/tempFile.txt");
        System.out.println(shell.path().equals("/Users/akhi/tempDir/tempFile2.txt"));

        //remove single file
//        shell.del("../tempFile2.txt");
//        shell.cd("../tempFile2.txt");
//        //assert !shell.path().equals("/usr/tempDir/tempFile2.txt");
//        System.out.println(!shell.path().equals("/Users/akhi/tempDir/tempFile2.txt"));
//        System.out.println("Changed");

        //remove folder with files
        shell.cd("/");
        shell.cd("/Users/akhi");
        shell.rmdir("tempDir");



    }

}