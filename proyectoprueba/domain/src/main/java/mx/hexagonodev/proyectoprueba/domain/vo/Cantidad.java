package mx.hexagonodev.proyectoprueba.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Cantidad {
    int cantidad;

    public static Cantidad of(int cantidad) {
        return new Cantidad(cantidad);
    }

}
