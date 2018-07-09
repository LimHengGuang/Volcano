import { Component, OnInit } from '@angular/core';
import { MOCK_STORY } from '../mock-story'
import { HttpClient } from '@angular/common/http';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Util } from '../utilities/util';

@Component({
  selector: 'app-story-page',
  templateUrl: './story-page.component.html',
  styleUrls: ['./story-page.component.css']


})
export class StoryPageComponent implements OnInit {
  
  stories = [];
  
  constructor(private http: HttpClient) { }

  ngOnInit() {

    this.http.get("https://volcano-backend.herokuapp.com/stories", Util.getReqConfig()).subscribe(
      data => {
        this.stories = <any[]>data;
      },
      err => {
        Util.writeGenericError();
      }
    );
  }

}
