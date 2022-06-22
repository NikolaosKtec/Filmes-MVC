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

    @Size(min = 5, max = 32)
    @NotBlank(message = "O titúlo não pode ser nulo!")
    String titulo;

    @Size(min = 5, max = 32)
    @NotBlank(message = "O campo 'diretor' não pode ser nulo")
    String diretor;

    @Size(min = 4, max = 14)
    @NotBlank(message = "O campo 'lançamento' não pode ser nulo")
    String lancamento;


    String imagemUrl;

    @Size(min = 5, max = 255)
    String sinopse;

    @Min(0)
    @Max(5)
    Integer avaliacao;
}
