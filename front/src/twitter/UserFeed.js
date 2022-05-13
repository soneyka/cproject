import React, { useState, useEffect } from 'react'
import './UserFeed.css'
import Post from './Post'
import TweetBox from './TweetBox'
import FlipMove from 'react-flip-move'
import axios from 'axios'
import { useHistory } from "react-router";

function UserFeed({search}) {

    const [tweets, setTweets] = useState([])
    const history = useHistory()
    const currentUserName = localStorage.getItem('userName')

    useEffect(() => {
        axios.get(`http://localhost:8081/twitter/tweets/user/${currentUserName}`)
        .then((response) => {
            console.log(response)
            console.log(response.data)
            setTweets(response.data)
        })
        //console.log(search+",,,,,,,,,,,,,,")
    }, [])

    return (
        <div className="userFeed">
            <div className="userFeed__header" onClick={() => {
                history.push(`/twitter/user/${currentUserName}`)
            }}>
                <h2>{currentUserName}</h2>
                <p>{tweets.length} Твитов</p>
            </div>

            {/* <TweetBox/> */}

            <FlipMove>
                {tweets.filter((tweet) => {
                    if(search == null)
                        return tweet
                    else if(tweet.tweetBody.toLowerCase().includes(search.toLowerCase()))
                        return tweet
                    else
                        return null
                }).map(tweet =>
                    <Post
                        key={tweet.tweetId}
                        displayName={tweet.displayName}
                        username={tweet.userName}
                        verified={tweet.verified}
                        text={tweet.tweetBody}
                        image={tweet.tweetImage}
                        avatar={tweet.avatar}
                        isPostFooterIcon={false}
                        tweetId={tweet.tweetId}
                        tweetCreationTime={tweet.tweetCreationTime}
                        likes={tweet.likes}
                    /> 
                )} 
                {/* {tweets.map(tweet => (
                    <Post
                        key={tweet.tweetId}
                        displayName={tweet.displayName}
                        username={tweet.userName}
                        verified={tweet.verified}
                        text={tweet.tweetBody}
                        image={tweet.tweetImage}
                        avatar={tweet.avatar}
                    />
                ))}  */}
            </FlipMove>

        </div>
    )
}

export default UserFeed
