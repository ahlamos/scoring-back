package com.example.com.controleur;

import com.example.com.dao.NotationRepository;
import com.example.com.dao.SegementRepository;
import com.example.com.entities.Notation;
import com.example.com.entities.Segment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class SegmentRestService {

    @Autowired
    private SegementRepository segmentRepository;

    @Autowired
    private NotationRepository notationRepository;
    @RequestMapping(value = "/majSegments", method = RequestMethod.POST)
    public void majSegments(@RequestBody List<Segment> segments) {
        segmentRepository.deleteAll();
        for(Segment segment:segments) {
            Notation notation=segment.getNotation();
            if(notation.getId()!=null) segmentRepository.save(segment);
            else {
                notationRepository.save(notation);
                segmentRepository.save(segment);
            }
        }
    }
}
