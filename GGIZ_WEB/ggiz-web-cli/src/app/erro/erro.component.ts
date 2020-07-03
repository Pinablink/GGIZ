import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'ggiz-erro',
  templateUrl: './erro.component.html',
  styleUrls: ['./erro.component.css']
})
export class ErroComponent implements OnInit {

  public serverNotFound: boolean;
  constructor(private router: ActivatedRoute) { }


  ngOnInit(): void {
    this.serverNotFound = ((this.router.snapshot.paramMap.get('conf')) === 'true');
  }

}
