.main{
    width:100%;
    height:100%;
    background-color:black;
}
nav{
    width: 100%;
    height: 75px;
    display: flex;
    background-color: black;
}
.logo{
    flex-basis:20%;
    }
    .logo img{
        width:120px;
        }
        .App{
            flex:2;
            text-align:center;
            }
            .App ul li{
            display:inline-block;
            margin:0 20px;
            }
            .App ul li a{
            color:#fff;
            text-decoration:none;
            }
            .App ul li::after{
            content:'';
            height:3px;
            width:0;
            background:white;
            left:0;
            bottom:-10px;
            transition:0.5s;
            }
            .App ul li:hover::after{
            width:100%;
            }
        .content img{
            width:800px;
            margin-bottom:-100px;
            margin-left: 800px;
        }
        .content p{
            color:#fff;
            font-size: 200%;
            margin-right: 800px;

            }
            button{
            padding:10px 50px;
            margin-right: 800px;
            }
            button a{
            text-decoration:none;
            color:black;
            font-weight:bold;
            font-size:13px;
            }
            .container {
                padding: 2rem;
                max-width: 800px; /* Max width for the slider */
                margin: 0 auto;
            }
    
            .slide-wrapper {
                position: relative;
                overflow: hidden; /* Hides overflow so only the visible slides show */
            }
    
            .slider {
                display: flex;
                overflow-x: scroll; /* Enable horizontal scroll */
                scroll-snap-type: x mandatory; /* Snap effect for smooth transitions */
                scroll-behavior: smooth; /* Smooth sliding between views */
                box-shadow: 0 1.5rem 3rem -0.75rem hsla(0, 0%, 0%, 0.25);
                border-radius: 0.5rem;
                -webkit-overflow-scrolling: touch; /* Smooth touch scroll for mobile */
            }
    
            .slider .slide {
                flex: 0 0 100%; /* Each slide takes up the full width of the viewport */
                scroll-snap-align: start;
                display: flex;
                flex-direction: column; /* Stack image and product info vertically */
                align-items: center;
                padding: 1rem;
            }
    
            .slider img {
                width: 80%; /* Image takes 80% of the slide width */
                height: auto;
                object-fit: cover;
                border-radius: 0.5rem;
            }
    
            /* Product information styling */
            .product-info {
                text-align: center;
                padding: 1rem 0;
                font-size: 1.2rem;
                color: #333;
            }
    
            /* Pagination dots */
            .slider-nav {
                display: flex;
                justify-content: center;
                margin-top: 1.5rem;
            }
    
            .slider-nav a {
                width: 0.75rem;
                height: 0.75rem;
                border-radius: 50%;
                background-color: #fff;
                margin: 0 0.5rem;
                opacity: 0.75;
                transition: opacity ease 250ms;
            }
    
            .slider-nav a:hover {
                opacity: 1;
            }

