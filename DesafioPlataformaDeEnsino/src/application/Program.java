package application;

import entities.Lesson;
import entities.Task;
import entities.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Lesson> licoes = new ArrayList<>();

        System.out.print("Quantas aulas tem o curso? ");
        int aulas = sc.nextInt();
        System.out.println();

        for(int i=0; i<aulas; i++){
            System.out.println("Dados da " + (i+1) + "ª aula:");
            System.out.print("Conteúdo ou tarefa (c/t)? ");
            char resposta = sc.next().charAt(0);
            System.out.print("Título: ");
            sc.nextLine();
            String titulo = sc.nextLine();
            if(resposta == 'c'){
                System.out.print("URL do vídeo: ");
                String url = sc.nextLine();
                System.out.print("Duração em segundos: ");
                int segundos = sc.nextInt();
                Video video = new Video(titulo, url, segundos);
                licoes.add(video);
            } else {
                System.out.print("Descrição: ");
                String descricao = sc.nextLine();
                System.out.print("Quantidade de questões: ");
                int questoes = sc.nextInt();
                Task task = new Task(titulo, descricao, questoes);
                licoes.add(task);
            }
            System.out.println();
        }

        int sum = 0;
        for(Lesson l : licoes){
            sum += l.duration();
        }

        System.out.println();
        System.out.println("DURAÇÃO TOTAL DO CURSO = " + sum + " segundos");

        sc.close();
    }
}
