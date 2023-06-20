package com.icia.test.Entity;

import com.icia.test.DTO.BoardDTO;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="board_test_table")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long board_id;

    @Column(length=30, nullable = false)
    private String board_writer;

    @Column(length=50, nullable = false)
    private String board_title;

    @Column(length=500)
    private String board_contents;

    @Column
    private int board_hits;

    @Column
    private LocalDateTime board_created_time;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="memberId")
    private MemberEntity memberEntity;

    public static BoardEntity toSaveEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoard_id(boardDTO.getBoard_id());
        boardEntity.setBoard_writer(boardDTO.getBoard_writer());
        boardEntity.setBoard_title(boardDTO.getBoard_title());
        boardEntity.setBoard_contents(boardDTO.getBoard_contents());
        boardEntity.setBoard_hits(0);
        boardEntity.setBoard_created_time(boardDTO.getBoard_created_time());
        return boardEntity;
    }
}
