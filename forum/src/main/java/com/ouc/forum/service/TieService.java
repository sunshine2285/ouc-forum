package com.ouc.forum.service;

import com.ouc.forum.DTO.TieDTO;
import com.ouc.forum.entity.Tie;
import com.ouc.forum.repository.ReplyRepository;
import com.ouc.forum.repository.TieRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @Author Song
 * @create 2020/9/10 0:15
 */
@Service
public class TieService {
    @Resource
    private TieRepository tieRepository;
    @Resource
    private ReplyRepository replyRepository;

    public ArrayList<Tie> getAllTie(long mid) {
        return tieRepository.findAllByMid(mid);
    }

    public TieDTO getTie(long id, final boolean isView) {
        Optional<Tie> optionalTie = tieRepository.findById(id);
        if (optionalTie.isPresent()) {
            Tie tie = optionalTie.get();
            if (isView) {
                tie.setView(tie.getView() + 1);
                tieRepository.save(tie);
            }
            return new TieDTO(tie, replyRepository.replyCount(id) + 1);
        }
        return null;
    }

    public ArrayList<Tie> searchTie(String key) {
        return tieRepository.findAllByTitleLike('%' + key + '%');
    }

    public Tie createTie(Tie tie) {
        tie.setPostTime(new Timestamp(System.currentTimeMillis()));
        return tieRepository.save(tie);
    }

    public ArrayList<TieDTO> searchHotTie(int count) {
        ArrayList<Tie> all = (ArrayList<Tie>) tieRepository.findAll(Sort.by(Sort.Direction.DESC, "view"));
        ArrayList<TieDTO> top = new ArrayList<>();
        for (int i = 0; i < count && i < all.size(); i++) {
            top.add(new TieDTO(all.get(i), replyRepository.replyCount(all.get(i).getId()) + 1));
        }
        return top;
    }

    public ArrayList<Tie> getUserTie(long uid) {
        return tieRepository.findAllByUid(uid);
    }

    public void deleteTie(long id) {
        tieRepository.deleteById(id);
    }

    public String likeTie(long id) {
        return "OK";
    }
}
