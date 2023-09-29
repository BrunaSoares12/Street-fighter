/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.exercicio_sf_aula6;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author bruni
 */
public class Exercicio_SF_Aula6 {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        Scanner ler = new Scanner(System.in);
        
        String matrizNomesPersonagens[][] = new String [2][6];
        String jogadorSelecionado;
        int ordemPersonagem = 1;
        boolean conferirPersonagem=true;
        
        System.out.println("____CADASTRANDO PERSONAGENS____");
        
        for(int i=0; i<2; i++){
            for(int j=0; j<6; j++){
                System.out.println("Digite o nome do "+ordemPersonagem+"º personagem: ");
                matrizNomesPersonagens[i][j] = ler.next();
                ordemPersonagem++;
            }
        }
        
        do{
            System.out.println("____SELECIONANDO PERSONAGEM____");
            System.out.println("Digite o nome do lutador que deseja utilizar no jogo: ");
            jogadorSelecionado = ler.next();
            
            conferirPersonagem = ConferirExistenciaLutador(jogadorSelecionado, matrizNomesPersonagens);
        }
        while(conferirPersonagem==false);
        
        System.out.println("____ROTEIRO DE LUTA____");
        
        ordemPersonagem = 1;
        
        for(int i=0; i<2; i++){
            for(int j=0; j<6; j++){
                if(matrizNomesPersonagens[i][j].equals(jogadorSelecionado)){
                    System.out.println(ANSI_RED+ordemPersonagem+"º personagem ("+matrizNomesPersonagens[i][j]+") está atualmente selecionado!"+ANSI_RESET);
                    if(j==5){
                       i++; 
                       j = 0;
                    }
                    else{
                        j++;
                    }
                    System.out.println(ordemPersonagem+"º adversário será então: "+matrizNomesPersonagens[i][j]);
                } 
                else {
                    System.out.println(ordemPersonagem+"º adversário será: "+matrizNomesPersonagens[i][j]);
                }
                ordemPersonagem++;
            }
        }
        
    }
    
    public static boolean ConferirExistenciaLutador(String jogadorSelecionado, String matrizNomesPersonagens[][]){
        boolean conferirPersonagem = true;
        for(int i=0; i<2; i++){
                for(int j=0; j<6; j++){
                    if(!jogadorSelecionado.equalsIgnoreCase(matrizNomesPersonagens[i][j])){
                        conferirPersonagem = false;
                    }
                    else{
                        conferirPersonagem = true;
                        i=1;
                        j=5;
                    }
                }
            }
            if(conferirPersonagem==false){
                System.out.println(ANSI_RED+"LUTADOR NÃO EXISTENTE!!!"+ANSI_RESET);
            }
            return conferirPersonagem;
    }
}
