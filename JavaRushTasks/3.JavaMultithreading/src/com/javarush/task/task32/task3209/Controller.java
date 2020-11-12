package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;
    HTMLFileFilter fileFilter;

    public Controller(View view){
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void init(){
        createNewDocument();
    }

    public void exit(){
        System.exit(0);
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void resetDocument(){
        if (document != null)
            document.removeUndoableEditListener(view.getUndoListener());
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text){
        resetDocument();
        StringReader reader = new StringReader(text);
        try {
            new HTMLEditorKit().read(reader, document, 0);
        } catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText(){
        StringWriter writer = new StringWriter();
        try {
            new HTMLEditorKit().write(writer, document, 0, document.getLength());
        } catch (Exception e){
            ExceptionHandler.log(e);
        }
        return writer.toString();
    }

    public void createNewDocument(){
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument(){
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        fileChooser.setDialogTitle("Open File");
        if (fileChooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION){
            resetDocument();
            currentFile = fileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try {
                try (FileReader reader = new FileReader(currentFile)) {
                    new HTMLEditorKit().read(reader, document, 0);
                }
            }catch (Exception e){
                ExceptionHandler.log(e);
            }
            view.resetUndo();
        }
    }

    public void saveDocument(){
        view.selectHtmlTab();
        if (currentFile == null)
            saveDocumentAs();
        else {
            try {
                try (FileWriter writer = new FileWriter(currentFile)) {
                    new HTMLEditorKit().write(writer, document, 0, document.getLength());
                }
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs(){
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        fileChooser.setDialogTitle("Save File");
        if (fileChooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION){
            currentFile = fileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try {
                try (FileWriter writer = new FileWriter(currentFile)) {
                    new HTMLEditorKit().write(writer, document, 0, document.getLength());
                }
            }catch (Exception e){
                ExceptionHandler.log(e);
            }
        }
    }
}
