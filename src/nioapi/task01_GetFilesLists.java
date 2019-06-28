/*
Получить список всех файлов рекурсивно от заданного пути
 */
package nioapi;
import utils.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

@LabAnnotation(
        number = "01-02",
        text = "1. Получить список всех файлов рекурсивно от заданного пути.\n" +
                "2. Получить список всех файлов рекурсивно от заданного пути с заданным форматом.")
public class task01_GetFilesLists extends task {
    public task01_GetFilesLists() {
        super();

        Path fso = FileSystems.getDefault().getPath("./");
        System.out.println("list of files from dir \""+fso.toString()+"\":");
        PathMatcher filter = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        System.out.println("filenames pattern: *.txt");
        try {
            getFilesList(fso, filter)
                    .forEach(el->{
                        System.out.println(el.toString());
                    });
        } catch (IOException e) {
            System.out.println("IO error reading directory \""+fso.toString()+"\"!");
        }
    }

    public static Stream<Path> getFilesList(Path path, PathMatcher filter) throws IOException {
        Stream<Path> files = Files.list(path)
                .flatMap(el->{
                    Stream<Path> result;

                    if (Files.isDirectory(el)) {
                        try {
                            result = getFilesList(el, filter);
                        } catch (IOException e) {
                            try {
                                throw new IOException();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            result = Stream.empty();
                        }
                    } else {
                        if (filter!=null)
                            result = filter.matches(el.getFileName())? Stream.of(el): Stream.empty();
                        else result = Stream.of(el);
                    }
                    return result;
                });
        return files;
    }
}
