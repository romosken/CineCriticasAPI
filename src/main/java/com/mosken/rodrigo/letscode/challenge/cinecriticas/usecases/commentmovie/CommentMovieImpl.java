package com.mosken.rodrigo.letscode.challenge.cinecriticas.usecases.commentmovie;

import com.mosken.rodrigo.letscode.challenge.cinecriticas.adapters.mysql.domain.CommentBean;
import com.mosken.rodrigo.letscode.challenge.cinecriticas.domain.dto.CommentDto;
import com.mosken.rodrigo.letscode.challenge.cinecriticas.entities.db.Comment;
import com.mosken.rodrigo.letscode.challenge.cinecriticas.usecases.commentmovie.port.ICommentMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CommentMovieImpl implements ICommentMovie {

    private final ICommentMovieService iCommentMovieService;
//    private final IAddXp iAddXp;


    @Override
    public CommentMovieResponse commentMovie(CommentMovieRequest request) {
        var responseCommentMovie = iCommentMovieService.createComment(buildCommentDto(request));
        var entity = validateResponse(responseCommentMovie);

//        iAddXp.addXpToUser(AddXpRequest.builder().username(request.getUsername()).xpToAdd(1).build());
        return buildCommentMovieResponse(entity);
    }

    private CommentDto buildCommentDto(CommentMovieRequest request) {
        return CommentDto.builder()
                .username(request.getUsername())
                .movieId(request.getMovieId())
                .text(request.getText())
                .commentReference(request.getCommentReference())
                .commentReply(request.getCommentReply())
                .build();
    }

    private Comment validateResponse(CommentBean response) {
        return Comment.builder()
                .id(response.getId())
                .username(response.getUsername())
                .movieId(response.getMovieId())
                .text(response.getText())
                .commentReference(Objects.isNull(response.getCommentReference()) ? 0 : response.getCommentReference().getId())
                .commentReply(Objects.isNull(response.getCommentReply()) ? 0 : response.getCommentReply().getId())
                .build();
    }

    private CommentMovieResponse buildCommentMovieResponse(Comment comment) {
        return CommentMovieResponse.builder()
                .id(comment.getId())
                .username(comment.getUsername())
                .movieId(comment.getMovieId())
                .text(comment.getText())
                .commentReference(comment.getCommentReference())
                .commentReply(comment.getCommentReply())
                .build();
    }


}