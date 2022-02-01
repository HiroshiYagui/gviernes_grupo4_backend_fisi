package com.freecode.redditclone.mapper;

import java.util.Optional;

import com.freecode.redditclone.dto.MedicamentoDto;
import com.freecode.redditclone.model.Medicamento;
import com.freecode.redditclone.model.Receta;
import com.github.marlonlom.utilities.timeago.TimeAgo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(componentModel="spring")
public interface MedicamentoMapper {


    public Medicamento map(MedicamentoDto medicamentoDto);

    public  MedicamentoDto mapToDto(Medicamento medicamento);

    //public  MedicamentoDispDto mapToDispDto(Medicamento medicamento);

    public void UpdateFromDto(MedicamentoDto medicamentoDto, @MappingTarget Medicamento medicamento);

    /*Integer commentCount(Post post){
        return commentRepository.findByPost(post).size();
    }

    String getDuration(Post post){
        return TimeAgo.using(post.getCreatedDate().toEpochMilli());
    }

    boolean isPostUpVoted(Post post){
        return checkVoteType(post,UPVOTE);
    }

    boolean isPostDownvoted(Post post){
        return checkVoteType(post,DOWNVOTE);
    }

    private boolean checkVoteType(Post post,VoteType voteType){
        if(authService.isLoggedIn()){
            Optional<Vote> voteForPostByUser=
                    voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post,
                                    authService.getCurrentUser());
            return voteForPostByUser.filter(vote -> vote.getVoteType().equals(voteType))
                                    .isPresent();
            }

        return false;
    }*/
}

