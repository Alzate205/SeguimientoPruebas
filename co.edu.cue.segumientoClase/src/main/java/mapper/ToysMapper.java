package mapper;

import dtos.ToysDTO;
import model.Toys;

public class ToysMapper {
    public static Toys mapFrom(ToysDTO toysDTO){
        return new Toys();
    }


    public static ToysDTO mapFrom(Toys toy){
        return  new ToysDTO(toy.getName(),toy.getType(),toy.getPrice(),toy.getAmount()  );
    }
}
