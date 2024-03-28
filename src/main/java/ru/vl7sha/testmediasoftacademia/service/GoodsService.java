package ru.vl7sha.testmediasoftacademia.service;

import com.sun.net.httpserver.Authenticator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vl7sha.testmediasoftacademia.exception.UIException;
import ru.vl7sha.testmediasoftacademia.model.entity.Goods;
import ru.vl7sha.testmediasoftacademia.repository.GoodsRepository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GoodsService {

    private final GoodsRepository goodsRepository;

    @Transactional
    public void save(Goods goods) {
        Goods goods1 = new Goods();
        if (Objects.nonNull(goods.getId())) {
            goods1 = getGoodsById(goods.getId());
            goods.setId(goods1.getId());
            goodsRepository.save(goods);
        }
        else {
            goodsRepository.save(goods);
        }
    }

    @Transactional
    public void remove(UUID uuid) {
        goodsRepository.deleteById(uuid);
    }

    public List<Goods> getGoodsList() {
        return goodsRepository.findAll();
    }

    public Goods getGoodsById(UUID uuid) {
        return goodsRepository.findById(uuid)
                .orElseThrow(
                        () -> new UIException("Товара с таким id нет")
                );
    }
}
