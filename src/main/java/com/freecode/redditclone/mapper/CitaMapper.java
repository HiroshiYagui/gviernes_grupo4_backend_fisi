package com.freecode.redditclone.mapper;

import java.util.Optional;

import com.freecode.redditclone.dto.CitaDto;
import com.freecode.redditclone.model.Cita;
import com.freecode.redditclone.model.Receta;
import com.freecode.redditclone.model.User;
import com.freecode.redditclone.service.AuthService;
import com.github.marlonlom.utilities.timeago.TimeAgo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(componentModel="spring")
public interface CitaMapper {

    /*@Autowired
    private CommentRepository commentRepository;
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private AuthService authService;*/

    

    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description" , source = "postRequest.description")
    @Mapping(target = "subreddit", source = "subreddit")
    @Mapping(target = "voteCount", constant = "0")
    @Mapping(target = "user", source = "user")
    public Cita map(CitaDto citaDto, Receta receta, User user);

    @Mapping(target = "id",source = "postId")
    @Mapping(target = "subredditName" , source="subreddit.name")
    @Mapping(target = "userName",source = "user.username")
    //@Mapping(target = "commentCount",source = "java(commentCount(post))")
    //@Mapping(target = "duration", source = "java(getDuration(post))")
    //@Mapping(target = "upVote",expression = "java(isPostUpVoted(post))")
    //@Mapping(target = "downVote",expression = "java(isPostDownvoted(post))")
    public  CitaDto mapToDto(Cita cita);

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

