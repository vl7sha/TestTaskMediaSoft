package ru.vl7sha.testmediasoftacademia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.vl7sha.testmediasoftacademia.exception.UIException;
import ru.vl7sha.testmediasoftacademia.mapper.GoodsMapper;
import ru.vl7sha.testmediasoftacademia.model.dto.GoodsDTO;
import ru.vl7sha.testmediasoftacademia.service.GoodsService;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/goods")
@RequiredArgsConstructor
public class GoodsController extends AbstractController {

    private final GoodsService goodsService;
    private final GoodsMapper goodsMapper;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<GoodsDTO>> getGoodsList() {
        return ResponseEntity.ok(
                goodsMapper.map(
                        goodsService.getGoodsList()
                )
        );
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<GoodsDTO> getGoodsById(
            @PathVariable("id") String id
    ) {
        return ResponseEntity.ok(
                goodsMapper.map(
                        goodsService.getGoodsById(
                                UUID.fromString(id)
                        )
                )
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(
            @Validated @RequestBody GoodsDTO goodsDTO
    ) {
        logRequest(goodsDTO);
        if (Objects.isNull(goodsDTO)) {
            throw new UIException("Вы ничего не прислали");
        }
        goodsService.save(
                goodsMapper.map(goodsDTO)
        );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> remove(
            @RequestBody GoodsDTO goodsDTO
    ) {
        logRequest(goodsDTO);
        goodsService.remove(
                goodsMapper.map(goodsDTO).getId()
        );
        return ResponseEntity.ok().build();
    }

}
