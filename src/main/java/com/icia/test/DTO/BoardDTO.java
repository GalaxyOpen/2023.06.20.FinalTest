package com.icia.test.DTO;

import com.icia.test.Entity.BoardEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class BoardDTO {
    private Long board_id;
    private String board_writer;
    private String board_title;
    private String board_contents;
    private int board_hits;
    private LocalDateTime board_created_time;

    public static BoardDTO toDTO(BoardEntity boardEntity) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoard_id(boardEntity.getBoard_id());
        boardDTO.setBoard_writer(boardEntity.getBoard_writer());
        boardDTO.setBoard_title(boardEntity.getBoard_title());
        boardDTO.setBoard_contents(boardEntity.getBoard_contents());
        boardDTO.setBoard_hits(boardEntity.getBoard_hits());
        boardDTO.setBoard_created_time(boardEntity.getBoard_created_time());
        return boardDTO;
    }
}
