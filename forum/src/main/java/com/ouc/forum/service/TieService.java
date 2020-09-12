package com.ouc.forum.service;

import com.ouc.forum.DTO.TieDTO;
import com.ouc.forum.entity.Tie;
import com.ouc.forum.repository.ReplyRepository;
import com.ouc.forum.repository.TieRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import javax.sound.midi.Soundbank;
import java.sql.Timestamp;
import java.util.ArrayList;

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

    public TieDTO getTie(long id) {
        Tie tie = tieRepository.findById(id);
        tie.setView(tie.getView() + 1);
        tieRepository.save(tie);
        TieDTO tieDTO = new TieDTO(tie,replyRepository.replyCount(id) + 1);
        return tieDTO;
    }

    public ArrayList<Tie> searchTie(String key) {
        return tieRepository.findAllByTitleLike('%' + key + '%');
    }

    public Tie createTie(Tie tie) {
        tie.setPostTime(new Timestamp(System.currentTimeMillis()));
        return tieRepository.save(tie);
    }

    public ArrayList<Tie> searchHotTie() {
        ArrayList<Tie> all = (ArrayList<Tie>) tieRepository.findAll(Sort.by(Sort.Direction.DESC, "view"));
        ArrayList<Tie> top = new ArrayList<Tie>();
        for (int i = 0; i < 1; i++) {
            top.add(all.get(i));
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
