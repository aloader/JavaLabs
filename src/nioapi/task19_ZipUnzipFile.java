/*
Заархивировать в zip несколько файлов.
Разархивировать файлы из zip. Расчитать размер каждого файла в архиве
 */
package nioapi;
import utils.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import static utils.Constants.BUFFERSIZE;

@LabAnnotation(
        number = "19",
        text = "Заархивировать в zip несколько файлов. \n" +
                "Разархивировать файлы из zip. \n" +
                "Расчитать размер каждого файла в архиве.")
public class task19_ZipUnzipFile extends task {
    public task19_ZipUnzipFile() {
        super();

        String dirIn = "./res";
        String dirOut = "./res/zip";
        String zipNameOut = "zip_files.zip";
        Path zipFileOut = Paths.get(dirOut, zipNameOut);
        ArrayList<Path> listFiles=null;

        // zip files mask "[\d].txt" from dir "./res" to "./res/zip/zip_files.zip"
        listFiles = getFilesList(Paths.get(dirIn), "[\\d].txt");
        if (listFiles == null) {
            System.out.println("no files to zip in the \""+ dirIn + "\".");
            return;
        }
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFileOut.toString()))) {
            System.out.println("\nadd files to zip-archive: " + zipFileOut.toString());
            for (Path fileIn:listFiles) {
                System.out.println("add: "+fileIn.toString());
                try (FileInputStream zipIn = new FileInputStream(fileIn.toString())) {
                    zipOut.putNextEntry(new ZipEntry(fileIn.getFileName().toString()));
                    writeBytes(zipIn, zipOut);
                    zipOut.closeEntry();
                } catch (FileNotFoundException e) {
                    System.out.println("file \"" + fileIn.toString() + "\" not found!");
                } catch (IOException e) {
                    System.out.println("IOExeption while zipping file \""+fileIn.toString()+"\"");
                }
            }
            System.out.println("zipping ends.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // work with zip file
        System.out.println("\nnow unzip files.");
        try (ZipFile zipFile = new ZipFile(zipFileOut.toString())) {
            Enumeration zipEntries = zipFile.entries();
            while (zipEntries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) zipEntries.nextElement();
                String fileOutName = dirOut + "/" + zipEntry.getName();
                System.out.println("file: \""+zipEntry.getName()+"\", size: " + zipEntry.getSize() +
                        ", extract to: \"" + fileOutName+ "\"");
                try (FileOutputStream fileOut = new FileOutputStream(fileOutName);
                        InputStream compressedData = zipFile.getInputStream(zipEntry)) {
                    writeBytes(compressedData, fileOut);
                } catch (IOException e) {
                    System.out.println("error unzipping file!");
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("error reading file: " + zipFileOut.toString());
            e.printStackTrace();
        };
        System.out.println("unzipping ends.");

    }

    private ArrayList<Path> getFilesList(Path path, String filter) {
        ArrayList<Path> filesList = null;
        try {
            filesList = Files.list(path)
                    .filter(f->f.getFileName().toString().matches(filter))
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        } catch (IOException e) {
        }
        return filesList;
    }

    private void writeBytes(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[BUFFERSIZE];
        int len;
        while ((len=in.read(buffer))>=0) {
            out.write(buffer, 0, len);
        }
    }
}
