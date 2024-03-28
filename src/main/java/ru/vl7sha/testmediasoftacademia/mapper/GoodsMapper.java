package ru.vl7sha.testmediasoftacademia.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.vl7sha.testmediasoftacademia.model.dto.GoodsDTO;
import ru.vl7sha.testmediasoftacademia.model.entity.Goods;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GoodsMapper {

    private final ModelMapper modelMapper;

    public Goods map(GoodsDTO goodsDTO){
        return modelMapper.map(goodsDTO, Goods.class);
    }

    public GoodsDTO map(Goods goods){
        return modelMapper.map(goods, GoodsDTO.class);
    }

    public List<GoodsDTO> map(List<Goods> goods){
        List<GoodsDTO> goodsDTOS = new ArrayList<>();
        for (var good: goods){
            goodsDTOS.add(map(good));
        }
        return goodsDTOS;
    }
}
