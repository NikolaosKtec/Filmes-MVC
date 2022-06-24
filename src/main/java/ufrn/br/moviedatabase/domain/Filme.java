package ufrn.br.moviedatabase.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max = 32, message = "ERR! tam min 5 e max 32")
    @NotBlank(message = "O titúlo não pode ser nulo!")
    String titulo;

    @Size(min = 5, max = 32,message = "ERR! tam min 5 e max 32")
    @NotBlank(message = "O campo 'diretor' não pode ser nulo!")
    String diretor;

    @Size(min = 10, max = 10, message = "não é uma data válida!")
    @NotBlank(message = "O campo 'lançamento' não pode ser nulo!")
    String lancamento;


    String imagemUrl;

    @Size(min = 5, max = 255, message = "Sinopse muito pequena, ou muito grande!")
    String sinopse;

    @Min(value = 0, message = "valor min é 0!")
    @Max(value = 5, message = "valor max é 5!")
    Integer avaliacao;
}
