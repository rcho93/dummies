import java.nio.file.NotDirectoryException;
import java.util.*;
import java.util.List;

class File {
    int size;
    FileType type;
    boolean isDir;
    List<File> children;
    String name;

    public File(String name, int size, FileType type, boolean isDir, List<File> children) {
        this.size = size;
        this.type = type;
        this.isDir = isDir;
        this.children = children;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

interface Filter {
    boolean apply(File file);
}

class SizeFilter implements Filter {
    int min; 

    public SizeFilter(int min) {
        this.min = min;
    }
    
    public boolean apply(File file) {
        return file.size >= min;
    }
}

class TypeFilter implements Filter {
    FileType type;
    
    public TypeFilter(FileType type) {
    this.type = type;
}

    public boolean apply(File file) {
        return type == file.type;
    }
}

public class Find {
    public static List<File> findWithFilter(File dir, List<Filter> filters) throws NotDirectoryException {
        if (!dir.isDir) {
            throw new NotDirectoryException(dir.getName());
        }

        List<File> output = new ArrayList<>();
        helper(dir, filters, output);
        return output;
    }

    public static void helper(File dir, List<Filter> filters, List<File> op) {
        if (dir.children.isEmpty() || dir.children == null) {
            return;
        }
        
        for (File file : dir.children) {
            boolean isApplied = true;
            for (Filter f : filters) {
                if (!f.apply(file)) {
                    isApplied = false;
                    break;
                }
            }

            if (isApplied) {
                op.add(file);
            }

            if (file.isDir) {
                helper(file, filters, op);
            }
        }
    }

    public static void main(String[] args) {
        File file1 = new File("old.txt", 3, FileType.TXT, true, new ArrayList<>());
        File file2 = new File("sec.txt", 3, FileType.TXT, false, new ArrayList<>());
        File file3 = new File("new.txt", 4, FileType.TXT, true, new ArrayList<>(Arrays.asList(file1, file2)));
        Filter sf = new SizeFilter(1);
        Filter tf = new TypeFilter(FileType.TXT);
        List<Filter> filters = new ArrayList<>(Arrays.asList(sf, tf));
        
        try {
            List<File> ret = Find.findWithFilter(file3, filters);
            
            for (File f : ret) {
                System.out.print(f.getName() + " ");
            }
        } catch (NotDirectoryException e) {
            System.out.println("non-directory file is found");
        }

    }
}

enum FileType {
    TXT, JSON, IMG
}
