package services;

import dtos.ToysDTO;
import model.Category;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public interface ToysService {
    List<ToysDTO> addToy(ToysDTO toysDTO) throws Exception;
    List<ToysDTO> listToys();


    ToysDTO search(String name) throws Exception;
    Map.Entry<Type,Integer> maxToy() throws Exception;
    Map.Entry<Type,Integer> minToy() throws Exception;
    List<ToysDTO> increase(ToysDTO toysDTO, int amount) throws Exception;
    List<ToysDTO> decrease(ToysDTO toysDTO, int amount) throws Exception;
    Map<Category, Integer> showByType() throws Exception;
    Map<Type,Integer> sort() throws Exception;
    List<ToysDTO> showToysAbove(double value) throws Exception;
    Boolean verifyExist(String name);
    Integer totalToys() throws Exception;
//    void  update(ToysDTO toysDTO) throws Exception;


}
