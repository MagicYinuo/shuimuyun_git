
;(function($){
    $.fn.fix = function(options){
        var defaults = {
            float : 'left',
			minStatue : false,
			skin : 'blue',
			durationTime : 1000	,
			stylewidth:'220',
			spacingw:30,
			spacingh:40,
			close_btn:'.close_btn',
			show_btn:'.show_btn',
			side_list:'.side_list',
			close_btn_width:25,
			side_title:'.side_title',
			set_scrollsidebar:'.page_right_style',
			table_menu:'.table_menu_list',
			widgetbox:'.widget-box'
        }
        var options = $.extend(defaults, options);		

        this.each(function(){			
            //��ȡ����
			var thisBox = $(this),
				closeBtn = thisBox.find(options.close_btn ),
				showbtn = thisBox.find(options.show_btn ),
				sideContent = thisBox.find('.side_content'),
				sideList = thisBox.find(options.side_list),
				sidetitle = thisBox.find(options.side_title),
				scrollsidebar=thisBox.find(options.set_scrollsidebar),
				stylespacing=thisBox.find(options.table_menu);
				widget_box=thisBox.find(options.widgetbox);
			var defaultTop = thisBox.offset().top;	//�����Ĭ��top	
			
			thisBox.css(options.float, 0);	
			//thisBox.css('height',(thisBox.height()));	
			if(options.minStatue){
				$(options.show_btn ).css("float", options.float);
				sideContent.css('width', 0);
				showbtn.css('width', (options.close_btn_width));
				thisBox.css('height',(thisBox.height()))-($(options.sideList).height());
				sideList.css('height',($(options.side_list).height()));		
			}
			//Ƥ������
			if(options.skin) thisBox.addClass('side_'+options.skin);
				
						
			//����scroll�¼�			
			//$(window).bind("scroll",function(){
//				var offsetTop = defaultTop + $(window).clientHeight()+ "px";
//	            showbtn.animate({
//	                top: offsetTop
//	            },
//	            {
//	                duration: options.durationTime,	
//	                queue: false    //�˶����������붯������
//	            });
//			});	
			//close�¼�
			closeBtn.bind("click",function(){
				sideContent.animate({width: '0px'},"fast").addClass('active');
            	showbtn.stop(true, true).delay(300).animate({ width:+(options.close_btn_width)+'px'},"fast");
				sideList.css("display","none");
				sidetitle.css("display","none");
				showbtn.css("display","block")
				scrollsidebar.addClass("Widescreen")
				scrollsidebar.width($(window).width()-(options.spacingw));
				stylespacing.width($(window).width()-(options.spacingw)).addClass("Widescreen");
				sideList.css('height',-($(options.side_list).height()));				
			    //widget_box.css('height',height($(window).height())-($(options.side_list).height()));	
		      
			});
			//show�¼�
			 showbtn.click(function() {
	            $(this).animate({width: '0px',border:'1px solid #ddd'},"fast").css('display','none');
	            sideContent.stop(true, true).delay(0).animate({ width:+(options.stylewidth)+'px'},"fast");
				sideList.css("display","block")
				sidetitle.css("display","block");
				scrollsidebar.removeClass("Widescreen")
				scrollsidebar.width($(window).width()-(options.stylewidth));
				stylespacing.width($(window).width()-(options.spacingh)).removeClass("Widescreen");
				sideList.css('height',145+($(options.side_list).height()));	
	        });
				
        });	//end this.each

    };
})(jQuery);