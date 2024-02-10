import {Component, OnInit} from '@angular/core';
import {ModelDetails} from "../../model/model-details";
import {ModelService} from "../../service/model.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-model-view',
  templateUrl: './model-view.component.html',
  styleUrls: ['./model-view.component.css', '../../../tables.css']
})
export class ModelViewComponent implements OnInit {

  model: ModelDetails | undefined;

  constructor(
      private service: ModelService,
      private route: ActivatedRoute,
      private router: Router
  ) {

  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.service.getModel(params['uuid'])
          .subscribe(model => this.model = model)
    })
  }
}
