import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class InverterCores {
    public static void main(String[] args) {
        try {
            // Carregar a imagem
            BufferedImage imagemOriginal = ImageIO.read(new File("C:\\Users\\DELL\\IdeaProjects\\inverter\\src\\Imagem\\sombrinhas.jpg"));

            // Obter a largura e a altura da imagem
            int largura = imagemOriginal.getWidth();
            int altura = imagemOriginal.getHeight();

            // Criar uma nova imagem com as mesmas dimensões
            BufferedImage imagemInvertida = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

            // Percorrer as linhas e colunas da imagem
            for (int x = 0; x < largura; x++) {
                for (int y = 0; y < altura; y++) {
                    // Obter a cor do pixel na posição (x, y)
                    Color corOriginal = new Color(imagemOriginal.getRGB(x, y));

                    // Inverter as cores
                    int r = 255 - corOriginal.getRed();
                    int g = 255 - corOriginal.getGreen();
                    int b = 255 - corOriginal.getBlue();

                    // Criar uma nova cor com as cores invertidas
                    Color corInvertida = new Color(r, g, b);

                    // Definir a cor invertida na nova imagem
                    imagemInvertida.setRGB(x, y, corInvertida.getRGB());
                }
            }

            // Salvar a imagem invertida
            File arquivoDeSaida = new File("C:\\Users\\DELL\\IdeaProjects\\inverter\\src\\Imagem\\sombrinhas.jpg");
            ImageIO.write(imagemInvertida, "jpg", arquivoDeSaida);

            System.out.println("Imagem invertida foi salva em: " + arquivoDeSaida.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
