package es.uniovi.dlp.codegenerator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    private PrintWriter out;
    private final List<Character> suffixes = List.of('i', 'f', 'b');
    private int label;

    public CodeGenerator(String outputFile, String inputFile) throws FileNotFoundException {
        this.out = new PrintWriter(outputFile);
        newLine();
        source(inputFile);
        newLine();
    }

    public void source(String inputFile){
        out.println("#source \"" + inputFile + "\"" );
        out.flush();
    }

    public void line(int line){
        out.println("#line " + line);
        out.flush();
    }

    public void label(String label){
        out.println(label + ":");
        out.flush();
    }

    public void comment(String comment){
        out.println("\t' * " + comment);
        out.flush();
    }

    public void push(char c){
        out.println("\tpushb " + (int)c);
        out.flush();
    }

    public void push(int i){
        out.println("\tpushi " + i);
        out.flush();
    }

    public void push(double d){
        out.println("\tpushf " + d);
        out.flush();
    }

    public void pusha(int a){
        out.println("\tpusha " + a);
        out.flush();
    }

    public void pushBP(){
        out.println("\tpush bp");
        out.flush();
    }

    public void load(char suffix){
        if(!suffixes.contains(suffix)){
            throw new IllegalArgumentException("Load cannot be done with '" + suffix + "' suffix");
        }
        out.println("\tload" + suffix);
        out.flush();
    }

    public void store(char suffix){
        if(!suffixes.contains(suffix)){
            throw new IllegalArgumentException("Store cannot be done with '" + suffix + "' suffix");
        }
        out.println("\tstore" + suffix);
        out.flush();
    }

    public void pop(char suffix){
        if(!suffixes.contains(suffix)){
            throw new IllegalArgumentException("Pop cannot be done with '" + suffix + "' suffix");
        }
        out.println("\tpop" + suffix);
        out.flush();
    }

    public void dup(char suffix){
        if(!suffixes.contains(suffix)){
            throw new IllegalArgumentException("Duplication cannot be done with '" + suffix + "' suffix");
        }
        out.println("\tdup" + suffix);
        out.flush();
    }

    public void arithmetic(char suffix, char operator){
        if(!suffixes.subList(0,2).contains(suffix)){
            throw new IllegalArgumentException("Arithmetic operation cannot be done with '" + suffix + "' suffix");
        }
        if(operator == '%' && suffix == 'f'){
            throw new IllegalArgumentException("Modulus cannot be done with '" + suffix + "' suffix");
        }

        switch (operator){
            case '+': out.println("\tadd" + suffix); break;
            case '-': out.println("\tsub" + suffix); break;
            case '*': out.println("\tmul" + suffix); break;
            case '/': out.println("\tdiv" + suffix); break;
            case '%': out.println("\tmod" + suffix); break;
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }

        out.flush();
    }

    public void comparison(char suffix, String operator){
        if(!suffixes.subList(0,2).contains(suffix)){
            throw new IllegalArgumentException("Arithmetic operation cannot be done with '" + suffix + "' suffix");
        }

        switch (operator){
            case ">": out.println("\tgt" + suffix); break;
            case "<": out.println("\tlt" + suffix); break;
            case ">=": out.println("\tge" + suffix); break;
            case "<=": out.println("\tle" + suffix); break;
            case "==": out.println("\teq" + suffix); break;
            case "!=": out.println("\tne" + suffix); break;

            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }

        out.flush();
    }

    public void and(){
        out.println("\tand");
        out.flush();
    }

    public void or(){
        out.println("\tor");
        out.flush();
    }

    public void not(){
        out.println("\tnot");
        out.flush();
    }

    public void output(char suffix){
        if(!suffixes.contains(suffix)){
            throw new IllegalArgumentException("Output operation cannot be done with '" + suffix + "' suffix");
        }

        out.println("\tout" + suffix);
        out.flush();
    }

    public void input(char suffix){
        if(!suffixes.contains(suffix)){
            throw new IllegalArgumentException("Input operation cannot be done with '" + suffix + "' suffix");
        }

        out.println("\tin" + suffix);
        out.flush();
    }

    public void conversion(char from, char to) {
        if (from == to) return;

        if (from == 'b' && to == 'i') out.println("\tb2i");
        else if (from == 'i' && to == 'f') out.println("\ti2f");
        else if (from == 'f' && to == 'i') out.println("\tf2i");
        else if (from == 'i' && to == 'b') out.println("\ti2b");
        else if (from == 'b' && to == 'f') {
            out.println("\tb2i");
            out.println("\ti2f");
        }
        else if (from == 'f' && to == 'b') {
            out.println("\tf2i");
            out.println("\ti2b");
        }
        else throw new IllegalArgumentException("Invalid conversion: " + from + " -> " + to);

        out.flush();
    }

    public void jmp(String label){
        out.println("\tjmp " + label);
        out.flush();
    }

    public void jz(String label){
        out.println("\tjz " + label);
        out.flush();
    }

    public void jnz(String label){
        out.println("\tjnz " + label);
        out.flush();
    }

    public void call(String id){
        out.println("\tcall " + id);
        out.flush();
    }

    public void enter(int nBytes){
        out.println("\tenter " + nBytes);
        out.flush();
    }

    public void returns(int returnBytes, int localBytes, int argBytes){
        out.println("\tret " + returnBytes + ", " + localBytes + ", " + argBytes);
        out.flush();
    }

    public void halt(){
        out.println("halt");
        out.flush();
    }

    public String getLabel(){
        return "label_" + this.label++;
    }

    public void newLine(){
        out.println();
    }

    public char promote(char c1, char c2) {
        if (c1 == 'f' || c2 == 'f') return 'f';
        return 'i';
    }
}
