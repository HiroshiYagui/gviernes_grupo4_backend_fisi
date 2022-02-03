package com.clinica.clinicaapp.mapper;

import java.util.Optional;

import com.clinica.clinicaapp.dto.CitaDto;
import com.clinica.clinicaapp.dto.CitaDispDto;
import com.clinica.clinicaapp.model.Cita;
import com.clinica.clinicaapp.model.Receta;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(componentModel="spring")
public interface CitaMapper {


    


    @Mapping(target = "disponible", constant = "true")
    public Cita map(CitaDto citaDto);

    public  CitaDto mapToDto(Cita cita);

    public  CitaDispDto mapToDispDto(Cita cita);

    public void UpdateFromDto(CitaDto citaDto, @MappingTarget Cita cita);

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
