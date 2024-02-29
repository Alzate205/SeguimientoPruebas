package services;

import dtos.ToysDTO;
import mapper.ToysMapper;
import model.Category;
import model.Toys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ToysServiceImpl implements ToysService {
        private List<Toys> toyList;

        @Override
        public List<ToysDTO> addToy(ToysDTO toysDTO) throws Exception {
            if(!verifyExist(toysDTO.name())){
                toyList.add(ToysMapper.mapFrom(toysDTO));
                return toyList.stream().map(ToysMapper::mapFrom).toList();
            }
            throw new Exception("This toy is not the list of toys");
        }

        @Override
        public List<ToysDTO> listToys() {
            return toyList.stream().map(ToysMapper::mapFrom).toList();
        }


        @Override
        public ToysDTO search(String name) throws Exception {
            if(verifyExist(name)){
                List<ToysDTO> list = toyList.stream().filter(toyList-> Objects.equals(toyList.getName(), name))
                        .findFirst().stream().map(ToysMapper::mapFrom).toList();

            }
            throw new Exception("Dont found the toy");
        }

        @Override
        public Map.Entry<Type,Integer> maxToy() throws Exception {
            return sort().entrySet().stream().reduce((first,second)-> second).orElse(null);
        }

        @Override
        public Map.Entry<Type,Integer> minToy() throws Exception {
            return sort().entrySet().stream().findFirst().orElse(null);
        }

        @Override
        public List<ToysDTO> increase(ToysDTO toysDTO, int amount) throws Exception {
            toyList.stream().filter(toy1 -> Objects.equals(toy1.getName(),toysDTO.name()))
                    .peek(toy -> toy.setAmount(toy.getAmount()+amount))
                    .findFirst();
            return toyList.stream().map(ToysMapper::mapFrom).toList();
        }
        @Override
        public List<ToysDTO> decrease(ToysDTO toysDTO, int amount) throws Exception {
            toyList.stream().filter(toy1 -> Objects.equals(toy1.getName(),toysDTO.name()))
                    .peek(toy -> {
                        if(toy.getAmount()>0){
                            toy.setAmount(toy.getAmount() - amount);
                        } else if (toy.getAmount()==0) {
                            toyList.remove(toy);
                        }
                    })
                    .findFirst();
            return toyList.stream().map(ToysMapper::mapFrom).toList();
        }


        @Override
        public Map<Category, Integer> showByType() throws Exception {
            Map<Category, Integer> showByType = new TreeMap<>();
            for(Toys toys : toyList){
                Category type = toys.getType();
                showByType.put(type,showByType.getOrDefault(type,0)+1);
            }
            return showByType;
        }

    @Override
    public Map<Type, Integer> sort() throws Exception {
        return null;
    }


    @Override
        public List<ToysDTO> showToysAbove(double value) throws Exception {
            return toyList.stream()
                    .filter(toy -> toy.getPrice() >= value)
                    .toList().stream().map(ToysMapper::mapFrom).toList();
        }
        @Override
        public Boolean verifyExist(String name) {
            return toyList.stream().anyMatch(e -> e.getName().equalsIgnoreCase(name));
        }
        @Override
        public Integer totalToys() throws Exception {
            double totalCount = 0;
            for (Toys toys : toyList){
                totalCount += toys.getAmount();
            }
            return (int) totalCount;
        }


        public int totalAmount(){
            return toyList.size();
        }

    }

