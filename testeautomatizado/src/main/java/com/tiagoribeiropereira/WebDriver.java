package com.tiagoribeiropereira;

import org.openqa.selenium.By; // Selecionar elementos
import org.openqa.selenium.Keys; // Selecionar teclas do teclado
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriver {
    
    public static void algoritmo() {

        // Professor minha propriedade do GeckoDriver foi adicionada ao meu PATH, logo não precisei usar o setProperty

        FirefoxDriver driver = null; // Iniciar o driver como null para fazer a condição no finally no final do algoritmo

        try {
            driver = new FirefoxDriver();
            driver.manage().window().maximize(); // Maximizar a janela que será aberta

            System.out.println("Navegando para bing");
            driver.get("https://www.bing.com/?cc=br"); // Pegar a URL do site

            // Adicionei este timer para dar tempo do pop-up de cookies aparecer e não estragar o processo
            Thread.sleep(2000);

            System.out.println("Procurando pela barra de pesquisa...");
            WebElement caixaPesquisa = driver.findElement(By.name("q")); // Procurar o elemento da caixa de pesquisa da página

            System.out.println("Digitando Hello World na barra de pesquisa.");
            caixaPesquisa.sendKeys("Hello World"); // Escrever Hello World no elemento selecionado

            System.out.println("Pressionando ENTER para pesquisar.");
            caixaPesquisa.sendKeys(Keys.ENTER); // Apertar ENTER no elemento selecionado

            System.out.println("Pesquisa realizada. Aguardando 10 segundos...");
            Thread.sleep(10000); // Timer de espera após realizar a pesquisa

            System.out.println("Título da página após a busca: " + driver.getTitle()); // Pegar o título da página

        }catch (Exception e){
            System.err.println("Ocorreu um erro durante a execução: " + e.getMessage());
            e.printStackTrace();
        }finally {
            if (driver != null) {
                driver.quit(); // Fechar o navegador
                System.out.println("Navegador Firefox fechado.");
            }
        }
    }
}
