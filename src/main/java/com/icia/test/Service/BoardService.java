package com.icia.test.Service;
import com.icia.test.DTO.BoardDTO;
import com.icia.test.Entity.BoardEntity;
import com.icia.test.Entity.MemberEntity;
import com.icia.test.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor

public class BoardService {
    private final BoardRepository boardRepository;
    public void save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        boardRepository.save(boardEntity);
    }

    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList=boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();

        boardEntityList.forEach((boardEntity ->
                boardDTOList.add(BoardDTO.toDTO(boardEntity))
        ));
        return boardDTOList;
    }

    public BoardDTO findById(Long id) {
        BoardEntity boardEntity = boardRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
        return BoardDTO.toDTO(boardEntity);
    }
}
